package billgenerate;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
class Item {
    int itemNumber;
    String itemName;
    double itemPrice;
    double itemDiscount;
    double discountedPrice;
    double itemTotalPrice;
    int quantity;

    @Override
    public String toString() {
        return "Item{" +
                "itemNumber=" + itemNumber +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + String.format("%.2f", itemPrice) +
                ", itemDiscount=" + itemDiscount +
                ", itemDiscountedPrice=" + String.format("%.2f", discountedPrice) +
                ", quantity=" + quantity +
                ", itemTotalPrice= " + String.format("%.2f", itemTotalPrice) +
                '}';
    }
}

public class BillGenerate {
    List<Item> itemList;
    double totalAmount;

    public void generateBill() {
        List<Item> itemList = createItemList();
        totalAmount = getTotalAmount(itemList);
        printList(itemList);
    }

    private void printList(List<Item> itemList) {
        System.out.println("_____________");
        for (Item i : itemList) {
            System.out.println(i.toString());
            System.out.println("_____________");
        }
        System.out.println("_____________");
        System.out.println("Total Amount:" + String.format("%.2f", totalAmount));
    }

    private double getTotalAmount(List<Item> itemList) {
        return itemList.stream().mapToDouble(item -> item.getItemTotalPrice()).sum();
    }

    private List<Item> createItemList() {
        List<Item> result = new ArrayList<>();
        for (int iterateItem = 0; iterateItem < 25; iterateItem++) {
            Item item = new Item();
            item.itemName = getName().toString();
            Random random = new Random();
            item.itemNumber = iterateItem;
            item.quantity = random.nextInt(5);
            if (item.quantity < 1) {
                item.setQuantity(1);
            }
            item.itemDiscount = random.nextInt(25);
            item.itemPrice = getItemPrice(item, random);
            item.discountedPrice = item.getItemPrice() * item.getItemDiscount() / 100;
            item.itemTotalPrice = (item.getItemPrice() - item.getDiscountedPrice()) * item.getQuantity();
            result.add(item);
        }
        return result;
    }

    private double getItemPrice(Item item, Random random) {
        if (item.itemDiscount < 10) {
            return random.nextDouble() + 500;
        }
        if (item.itemDiscount < 20) {
            return random.nextDouble() + 1000;
        }
        if (item.itemDiscount > 25 && item.itemDiscount > 20) {
            return random.nextDouble() + 1500;
        }
        return 0;
    }

    private StringBuilder getName() {
        char[] captialLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] smallLetters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Random random = new Random();
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            int randomInt = random.nextInt(captialLetters.length);
            if (i == 0) {
                name.append(captialLetters[randomInt]);
            } else {
                name.append(smallLetters[randomInt]);
            }
        }
        return name;
    }
}