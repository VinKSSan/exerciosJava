package operations;



import java.util.List;

import entitis.Sales;
import exception.OpcaoInvalida;

@FunctionalInterface
public interface SallerOperation {
	void operation(List<Sales> sales, Integer opt);
	
	default void opt(Integer opt) throws OpcaoInvalida{
		if(opt <1 || opt>3) {
			throw new OpcaoInvalida("numero diferente dos disponiveis(1,2,3)");
		}
	};
}
