package designModel.DecoraterModel;

public class Food {

	private String food_name;

	public Food() {
	}

	public Food(String food_name) {
		this.food_name = food_name;
	}

	public String make() {
		return food_name;
	}

	public static void main(String[] args) {
		  Food food = new Bread(new Vegetable(new Cream(new Food("香肠"))));
	       System.out.println(food.make());
	}
}