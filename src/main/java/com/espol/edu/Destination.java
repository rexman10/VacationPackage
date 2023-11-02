// Copyright (C) 2020
package com.espol.edu;

import java.util.Objects;

public class Destination {
    private String name;
    private boolean isItPopular;
    private float extraFee;

    /** @param input
     *  Partial constructor for the destination class. */
    public Destination(final String input) {
        this.name = input;
        this.isItPopular = false;
        this.extraFee = 0;
    }
    /** @param input
     *  @param bool
     *  @param extra
     *  Complete constructor for the destination class. */
    public Destination(final String input, final boolean bool, final float extra) {
        this.name = input;
        this.isItPopular = bool;
        this.extraFee = extra;
    }
    /** @return name attribute of the destination. */
    public String getName() {
        return name;
    }

    /** @param nameInput describes location name.
     * Sets the attribute value to the input parameter. */
    public void setName(final String nameInput) {
        this.name = nameInput;
    }

    /**
     * @return isPopular describes boolean existence.
     * Gets value of popularity if exists. */
    public boolean isPopular() {
        return isItPopular;
    }

    /**
     * @param isPopularInput describes boolean existence. */
    public void setPopular(final boolean isPopularInput) {
        this.isItPopular = isPopularInput;
    }

    /**
     * @return float that represents money.
     * Gets value of extra fee if exists. */
    public float getExtraFee() {
        return extraFee;
    }

    /**
     * @param extra a float representing money.
     * Sets @param extra fee if package is requested to a touristic spot. */
    public void setExtraFee(final float extra) {
        this.extraFee = extra;
    }



    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    /** {@inheritDoc} */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Destination other = (Destination) obj;
        return Objects.equals(name, other.name);
    }
}
