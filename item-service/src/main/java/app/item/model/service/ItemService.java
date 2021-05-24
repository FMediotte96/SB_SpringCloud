package app.item.model.service;

import app.item.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();

    Item findById(Long id, Integer cantidad);
}
