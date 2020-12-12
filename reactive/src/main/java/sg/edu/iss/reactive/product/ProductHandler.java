package sg.edu.iss.reactive.product;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class ProductHandler {
	
	@Autowired
	ProductRepository prepo;
	
	public Mono<ServerResponse> listProducts(ServerRequest request) {
		return ServerResponse.ok()
				.contentType(APPLICATION_JSON)
				.body(prepo.findAll(), Product.class);
	}

}
