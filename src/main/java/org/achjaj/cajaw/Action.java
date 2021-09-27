/*
 * Copyright (c) 2021 Jakub Bucko.
 *
 * This file is distributed under the MIT license. The wording of the license can be found here: https://mit-licens.org/
 */

package org.achjaj.covid;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.Serializable;
import java.util.Date;

/**
 * This class represents some measure active in some region in some week.
 */
public class Action implements Serializable {
    private String label,
                    text,
                    detail,
                    name;

    private Date validFrom;
    private Icon icon;
    private Category category;

    /**
     * Get the label
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Set the label. (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param label new label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Get the brief description.
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Set the text (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param text new text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Get the details if available.
     * @return the details or null
     */
    public String getDetail() {
        return detail;
    }

    /**
     * Set the details (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param detail new details
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * Get the code name.
     * @return the code name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the code name (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param name new code name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the category
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Set the category (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param category new category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Get the date from when the action is valid.
     * @return the date
     */
    public Date getValidFrom() {
        return validFrom;
    }

    /**
     * Set the date (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param validFrom new date
     */
    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    /**
     * Get the icon ID used by official website
     * @return the icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * Set the icon (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param icon new icon
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        try {
            return CovidAutomat.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
