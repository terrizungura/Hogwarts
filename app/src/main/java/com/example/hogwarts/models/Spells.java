package com.example.hogwarts.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Spells {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("spell")
    @Expose
    private String spell;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("effect")
    @Expose
    private String effect;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public Spells(){

    }

    public Spells(String id, String spell, String type, String effect, Integer v) {
        this.id = id;
        this.spell = spell;
        this.type = type;
        this.effect = effect;
        this.v = v;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public void newSpells(List<Spells> spellsList) {

    }

}