public class Cat extends Animal implements NoiseCapable {
  public Cat(String name) {
    super(name);
  }

  public Cat() {
    this("Cat");
  }

  public void purr() {
    System.out.println(this.getName() + " purrs");
  }

  @Override
  public void makeNoise() {
    this.purr();
  }

}
