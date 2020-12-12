package sg.edu.iss.reactive.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.test.StepVerifier;

@SpringBootTest
public class ProductCRUDTests {

	@Autowired
	private ProductRepository prepo;
	private Product product;

	@Test
	public void create() {
		Product newEntity = new Product(2, "n", 2);

		StepVerifier.create(prepo.save(newEntity))
				.expectNextMatches(createdEntity -> newEntity.getProductId() == createdEntity.getProductId())
				.verifyComplete();

		StepVerifier.create(prepo.findById(newEntity.getId()))
				.expectNextMatches(foundEntity -> areProductEqual(newEntity, foundEntity)).verifyComplete();

		StepVerifier.create(prepo.count()).expectNext(2l).verifyComplete();
	}

	@Test
	public void update() {
		product.setName("n2");
		StepVerifier.create(prepo.save(product))
				.expectNextMatches(updatedEntity -> updatedEntity.getName().equals("n2")).verifyComplete();

		StepVerifier.create(prepo.findById(product.getId()))
				.expectNextMatches(foundEntity -> foundEntity.getName().equals("n2")).verifyComplete();
	}

	@Test
	public void delete() {
		StepVerifier.create(prepo.delete(product)).verifyComplete();
		StepVerifier.create(prepo.existsById(product.getId())).expectNext(false).verifyComplete();
	}

	@Test
	public void getByProductId() {

		StepVerifier.create(prepo.findProductByProductId(product.getProductId()))
				.expectNextMatches(foundEntity -> areProductEqual(product, foundEntity)).verifyComplete();
	}

	private boolean areProductEqual(Product expectedEntity, Product actualEntity) {
		return (expectedEntity.getId().equals(actualEntity.getId()))
				&& (expectedEntity.getProductId() == actualEntity.getProductId())
				&& (expectedEntity.getName().equals(actualEntity.getName()));
	}

}
