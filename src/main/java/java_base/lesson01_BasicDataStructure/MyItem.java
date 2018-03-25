package java_base.lesson01_BasicDataStructure;

import java.io.Serializable;
import java.util.Objects;

public class MyItem implements Serializable {

    private byte type;
    private byte color;
    private byte price;

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getColor() {
        return color;
    }

    public void setColor(byte color) {
        this.color = color;
    }

    public byte getPrice() {
        return price;
    }

    public void setPrice(byte price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyItem item = (MyItem) o;
        return type == item.type &&
                color == item.color &&
                price == item.price;
    }

    @Override
    public int hashCode() {

        return Objects.hash(type, color, price);
    }

    @Override
    public String toString() {
        return "MyItem{" +
                "type=" + type +
                ", color=" + color +
                ", price=" + price +
                '}';
    }
}
