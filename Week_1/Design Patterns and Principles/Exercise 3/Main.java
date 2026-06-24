public class Main {
    public static void main(String[] args) {
        Computer gamingRig = new Computer.Builder()
                .setCpu("AMD Ryzen 9 7950X")
                .setRam("64GB DDR5")
                .setStorage("4TB NVMe SSD")
                .setGpu("NVIDIA RTX 4090")
                .setPowerSupply("1000W 80+ Gold")
                .build();

        Computer officeDesktop = new Computer.Builder()
                .setCpu("Intel Core i5-13400")
                .setRam("16GB DDR4")
                .setStorage("512GB SSD")
                .setPowerSupply("500W Bronze")
                .build();

        Computer homeServer = new Computer.Builder()
                .setCpu("Intel Core i3")
                .setRam("32GB ECC RAM")
                .setStorage("16TB HDD Array")
                .build();

        System.out.println(gamingRig);
        System.out.println(officeDesktop);
        System.out.println(homeServer);
    }
}