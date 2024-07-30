package builder;

public class Computer {
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final boolean graphicsCard;
    private final boolean bluetooth;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.bluetooth = builder.bluetooth;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage
                + ", graphicsCard=" + graphicsCard + ", bluetooth=" + bluetooth + "]";
    }

    // Static nested Builder class
    public static class Builder {
        private final String CPU;
        private final String RAM;
        private final String storage;
        private boolean graphicsCard = false;
        private boolean bluetooth = false;

        public Builder(String CPU, String RAM, String storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.storage = storage;
        }

        public Builder setGraphicsCard(boolean graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setBluetooth(boolean bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
