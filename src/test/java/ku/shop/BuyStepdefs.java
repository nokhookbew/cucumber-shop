package ku.shop;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("the following products exist:")
    public void the_following_products_exist(DataTable dataTable){
        Map<String,Double> data = dataTable.asMap(String.class, Double.class);

        for (String name : data.keySet()) {
            double price = data.get(name);
            catalog.addProduct(name, price);
        }

    }

    @Given("a product (.+) with price (.+) exists")
    public void a_product_with_price_exists(String name, double price) {
        catalog.addProduct(name, price);
    }

    @When("I buy (.+) with quantity (.+)")
    public void i_buy_with_quantity(String name, int quant) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quant);
    }

    @Then("total should be (.+)")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }

    @Given("a product (.+) for (.+) in stock with price (.+) for each product")
    public void a_product_for_in_stock_with_price_for_each_product(String name, int stock, double price){
        catalog.addProduct(name, price, stock);
    }

    @Given("We have these product")
    public void we_have_these_product(DataTable table) {
        Map<String,Double> data = table.asMap(String.class, Double.class);

        for (String name : data.keySet()) {
            double price = data.get(name);
            catalog.addProduct(name, price);
        }
    }


    @When("I buy (.+) (.+) that more than stock")
    public void I_buy_with_quantity_that_more_than_stock(int quantity, String name) throws NotEnoughException {
        Product prod = catalog.getProduct(name);
        OrderItem orderItem = new OrderItem(prod, quantity);
        assertThrows(NotEnoughException.class,
                () -> orderItem.checkStock());
    }

    @When("I buy (.+) (.+) that less than stock")
    public void I_buy_with_quantity_less_more_than_stock(int quantity, String name) throws NotEnoughException {
        Product prod = catalog.getProduct(name);
        OrderItem orderItem = new OrderItem(prod, quantity);
        orderItem.checkStock();
    }

    @Then("There are (.+) (.+) in stock")
    public void there_are_in_stock(int quantity, String name) {
        Product product = catalog.getProduct(name);
        assertEquals(quantity, product.getQuantity());
    }
}

