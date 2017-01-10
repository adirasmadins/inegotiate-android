package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Money extends Element {
    public static final AttributeKey<Double> AMOUNT;
    public static final AttributeKey<String> CURRENCY_CODE;
    public static final ElementKey<Void, Money> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "money"), Void.class, Money.class);
        AMOUNT = AttributeKey.of(new QName(null, "amount"), Double.class);
        CURRENCY_CODE = AttributeKey.of(new QName(null, "currencyCode"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(AMOUNT).setRequired(true);
            builder.addAttribute(CURRENCY_CODE).setRequired(true);
        }
    }

    public Money() {
        super(KEY);
    }

    protected Money(ElementKey<?, ? extends Money> key) {
        super((ElementKey) key);
    }

    protected Money(ElementKey<?, ? extends Money> key, Element source) {
        super(key, source);
    }

    public Money lock() {
        return (Money) super.lock();
    }

    public Double getAmount() {
        return (Double) super.getAttributeValue(AMOUNT);
    }

    public Money setAmount(Double amount) {
        super.setAttributeValue(AMOUNT, (Object) amount);
        return this;
    }

    public boolean hasAmount() {
        return super.hasAttribute(AMOUNT);
    }

    public String getCurrencyCode() {
        return (String) super.getAttributeValue(CURRENCY_CODE);
    }

    public Money setCurrencyCode(String currencyCode) {
        super.setAttributeValue(CURRENCY_CODE, (Object) currencyCode);
        return this;
    }

    public boolean hasCurrencyCode() {
        return super.hasAttribute(CURRENCY_CODE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        Money other = (Money) obj;
        if (Element.eq(getAmount(), other.getAmount()) && Element.eq(getCurrencyCode(), other.getCurrencyCode())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getAmount() != null) {
            result = (result * 37) + getAmount().hashCode();
        }
        if (getCurrencyCode() != null) {
            return (result * 37) + getCurrencyCode().hashCode();
        }
        return result;
    }
}
