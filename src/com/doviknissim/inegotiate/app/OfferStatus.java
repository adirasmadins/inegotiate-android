package com.doviknissim.inegotiate.app;

import com.google.gdata.util.common.base.StringUtil;

public enum OfferStatus {
    RECEIVED_NEW_OFFER("received.new", "Received new offer"),
    RECEIVED_AND_IGNORED_NEW_OFFER("received.ignored", "Received & ignored offer"),
    RECEIVED_AND_ACCEPTED_NEW_OFFER("received.accepted", "Received & accepted offer"),
    RECEIVED_AND_REJECTED_NEW_OFFER("received.rejected", "Received & rejected offer"),
    SENT_NEW_OFFER("sent.new", "New offer was sent"),
    SENT_AND_IGNORED_OFFER("sent.ignored", "Offer was sent & ignored"),
    SENT_AND_ACCEPTED_OFFER("sent.accepted", "Offer was sent & accepted"),
    SENT_AND_REJECTED_OFFER("sent.rejected", "Offer was sent & rejected"),
    SENT_AND_UPDATED_OFFER("sent.updated", "Offer was updated but not sent");
    
    private final String statusDbCode;
    private final String statusDisplayString;

    private OfferStatus(String dbCode, String displayString) {
        this.statusDbCode = dbCode;
        this.statusDisplayString = displayString;
    }

    public String getStatusDisplayString() {
        return this.statusDisplayString;
    }

    public String getStatusDbCode() {
        return this.statusDbCode;
    }

    public String toString() {
        return this.statusDisplayString;
    }

    public static String displayStatus(String statusDbCode) {
        if (statusDbCode == null || statusDbCode.length() == 0) {
            return StringUtil.EMPTY_STRING;
        }
        if (statusDbCode.equalsIgnoreCase(RECEIVED_NEW_OFFER.getStatusDbCode())) {
            return RECEIVED_NEW_OFFER.getStatusDisplayString();
        }
        if (statusDbCode.equalsIgnoreCase(RECEIVED_AND_IGNORED_NEW_OFFER.getStatusDbCode())) {
            return RECEIVED_AND_IGNORED_NEW_OFFER.getStatusDisplayString();
        }
        if (statusDbCode.equalsIgnoreCase(RECEIVED_AND_ACCEPTED_NEW_OFFER.getStatusDbCode())) {
            return RECEIVED_AND_ACCEPTED_NEW_OFFER.getStatusDisplayString();
        }
        if (statusDbCode.equalsIgnoreCase(RECEIVED_AND_REJECTED_NEW_OFFER.getStatusDbCode())) {
            return RECEIVED_AND_REJECTED_NEW_OFFER.getStatusDisplayString();
        }
        if (statusDbCode.equalsIgnoreCase(SENT_NEW_OFFER.getStatusDbCode())) {
            return SENT_NEW_OFFER.getStatusDisplayString();
        }
        if (statusDbCode.equalsIgnoreCase(SENT_AND_IGNORED_OFFER.getStatusDbCode())) {
            return SENT_AND_IGNORED_OFFER.getStatusDisplayString();
        }
        if (statusDbCode.equalsIgnoreCase(SENT_AND_ACCEPTED_OFFER.getStatusDbCode())) {
            return SENT_AND_ACCEPTED_OFFER.getStatusDisplayString();
        }
        if (statusDbCode.equalsIgnoreCase(SENT_AND_REJECTED_OFFER.getStatusDbCode())) {
            return SENT_AND_REJECTED_OFFER.getStatusDisplayString();
        }
        if (statusDbCode.equalsIgnoreCase(SENT_AND_UPDATED_OFFER.getStatusDbCode())) {
            return SENT_AND_UPDATED_OFFER.getStatusDisplayString();
        }
        return StringUtil.EMPTY_STRING;
    }
}
