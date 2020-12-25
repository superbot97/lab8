public class Main {

    public static void main(String[] args) {

        Bouquet bouquet = new Bouquet.Builder("3 Roses").build();
        System.out.println(bouquet.getFlowers());
        System.out.println(bouquet.band);
        bouquet = new Bouquet.Builder("5 Roses").band("It's band!").build();
        System.out.println(bouquet.getFlowers());
        System.out.println(bouquet.band);
    }
}

final class Bouquet {
    private final String flowers;
    public final String band;

    public String getFlowers(){
        return flowers;
    }

    private Bouquet(Builder builder) {
        this.flowers = builder.flowers;
        this.band = builder.band;
    }

    public static class Builder {

        private String flowers;

        private String band = "none";

        public Builder(String flowers) {
            this.flowers = flowers;
        }

        public Builder band(String band) {
            this.band = band;
            return this;
        }

        public Bouquet build() {
            return new Bouquet(this);
        }
    }
}