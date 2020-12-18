package sg.edu.iss.reactive.product;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<Product, String> {
      Mono<Product> findProductByProductId(int productId);
      Flux<Product> findProductsByName(String name);
      Flux<Product> findProductsByNameContaining(String name);
}
