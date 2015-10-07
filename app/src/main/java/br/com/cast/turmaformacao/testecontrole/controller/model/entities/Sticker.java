package br.com.cast.turmaformacao.testecontrole.controller.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Sticker implements Parcelable {

    private Long number;
    private Integer amount;
    private String name;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sticker)) return false;

        Sticker sticker = (Sticker) o;

        if (getNumber() != null ? !getNumber().equals(sticker.getNumber()) : sticker.getNumber() != null)
            return false;
        if (getAmount() != null ? !getAmount().equals(sticker.getAmount()) : sticker.getAmount() != null)
            return false;
        return !(getName() != null ? !getName().equals(sticker.getName()) : sticker.getName() != null);

    }

    @Override
    public int hashCode() {
        int result = getNumber() != null ? getNumber().hashCode() : 0;
        result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.number);
        dest.writeValue(this.amount);
        dest.writeString(this.name);
    }

    public Sticker() {
    }

    protected Sticker(Parcel in) {
        this.number = (Long) in.readValue(Long.class.getClassLoader());
        this.amount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Sticker> CREATOR = new Parcelable.Creator<Sticker>() {
        public Sticker createFromParcel(Parcel source) {
            return new Sticker(source);
        }

        public Sticker[] newArray(int size) {
            return new Sticker[size];
        }
    };
}
