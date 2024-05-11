package com.burgerbachelor.config;

import com.burgerbachelor.entity.Product;
import com.burgerbachelor.entity.Workshop;
import com.burgerbachelor.repository.ProductRepository;
import com.burgerbachelor.repository.WorkshopRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class DataConfig
{
    // Данные для инициализации базы данных питомцев
    @Bean
    public CommandLineRunner loadData(ProductRepository productRepository, WorkshopRepository workshopRepository)
    {
        return (args) -> {
            if (productRepository.findAll().isEmpty())
            {
                var products = new ArrayList<Product>();
                // Говядина
                products.add(new Product("DORKY PORKY", 590, "beef"));
                products.add(new Product("БРЯНСКИЙ ПАРЕНЬ", 620, "beef"));
                products.add(new Product("ЧИЗБУРГЕР", 590, "beef"));
                products.add(new Product("ПАПА МЯСНИКА", 820, "beef"));
                // Курица
                products.add(new Product("ГОРЯЧАЯ ЦЫПА", 550, "chiken"));
                products.add(new Product("Double-ЧИКЕН", 660, "chiken"));
                products.add(new Product("ЧИКЕНБУРГЕР", 490, "chiken"));
                products.add(new Product("ДОЧЬ МЯСНИКА", 730, "chiken"));
                // Напитки
                products.add(new Product("ЛИПТОН", 180, "drink"));
                products.add(new Product("ФАНТА", 200, "drink"));
                products.add(new Product("СПРАЙТ", 200, "drink"));
                products.add(new Product("КОКА-КОЛА", 210, "drink"));
                // Закуски
                products.add(new Product("КАРТОШКА ФРИ", 280, "snack"));
                products.add(new Product("НАГГЕТСЫ КУРИНЫЕ", 440, "snack"));
                products.add(new Product("КРЫЛЫШКИ КУРИНЫЕ", 420, "snack"));
                products.add(new Product("САЛАТ ОВОЩНОЙ", 410, "snack"));
                productRepository.saveAll(products);

                for (var product : products)
                {
                    workshopRepository.save(new Workshop(product, 50));
                }
            }
        };
    }
}
