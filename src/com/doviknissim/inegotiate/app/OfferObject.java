package com.doviknissim.inegotiate.app;

import android.util.Log;
import com.google.gdata.util.common.base.StringUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class OfferObject implements Comparable<OfferObject> {
    private String amount;
    private int buyerOrSeller;
    private String contact;
    private String currency;
    private String date;
    private String description;
    private String id;
    private String picturePath;
    private String product;

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getBuyerOrSeller() {
        return this.buyerOrSeller;
    }

    public void setBuyerOrSeller(int buyerOrSeller) {
        this.buyerOrSeller = buyerOrSeller;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicturePath() {
        return this.picturePath;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OfferObject(String Id, String date, String product, String description, String amount, String contact, String picturePath, int buyerOrSeller, String currency) {
        this.id = StringUtil.EMPTY_STRING;
        this.date = StringUtil.EMPTY_STRING;
        this.product = StringUtil.EMPTY_STRING;
        this.description = StringUtil.EMPTY_STRING;
        this.amount = StringUtil.EMPTY_STRING;
        this.contact = StringUtil.EMPTY_STRING;
        this.picturePath = StringUtil.EMPTY_STRING;
        this.currency = StringUtil.EMPTY_STRING;
        this.buyerOrSeller = 0;
        this.id = this.id;
        this.date = date;
        this.product = product;
        this.description = description;
        this.amount = amount;
        this.contact = contact;
        this.picturePath = picturePath;
        this.buyerOrSeller = buyerOrSeller;
        this.currency = currency;
    }

    public OfferObject(String id, String date, String product, String amount, String contact, String picturePath, int buyerOrSeller, String currency) {
        this.id = StringUtil.EMPTY_STRING;
        this.date = StringUtil.EMPTY_STRING;
        this.product = StringUtil.EMPTY_STRING;
        this.description = StringUtil.EMPTY_STRING;
        this.amount = StringUtil.EMPTY_STRING;
        this.contact = StringUtil.EMPTY_STRING;
        this.picturePath = StringUtil.EMPTY_STRING;
        this.currency = StringUtil.EMPTY_STRING;
        this.buyerOrSeller = 0;
        this.id = id;
        this.date = date;
        this.product = product;
        this.amount = amount;
        this.contact = contact;
        this.picturePath = picturePath;
        this.buyerOrSeller = buyerOrSeller;
        this.currency = currency;
    }

    public int compareTo(OfferObject o) {
        try {
            return new SimpleDateFormat("MMM-dd-yyyy").parse(getDate()).compareTo(new SimpleDateFormat("MMM-dd-yyyy").parse(o.getDate()));
        } catch (ParseException e) {
            Log.e("iNegotiate", "[ERROR] An exception was thrown while converting date information ");
            return 0;
        }
    }
}
