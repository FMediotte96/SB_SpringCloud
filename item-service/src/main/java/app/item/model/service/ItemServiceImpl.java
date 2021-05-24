package app.item.model.service;

import app.item.model.Item;
import app.item.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("restTemplateService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate restClient;

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(restClient.getForObject("http://product-service/listar",
                Producto[].class));
        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        Producto producto = restClient.getForObject("http://product-service/ver/{id}",
                Producto.class,
                pathVariables);
        return new Item(producto, cantidad);
    }
}
