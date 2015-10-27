package com.smithvillehighrobotics.android.frc2015scouting;

public class Stack {
    private int _id;
    private int _teamNumber;
    private int _matchNumber;
    private int _stackNumber;
    private int _totes;
    private int _can;
    private int _noodle;

    public Stack(){

    }

    public Stack(int totes, int can, int noodle, int matchNumber, int teamNumber){
        this._totes = totes;
        this._can = can;
        this._noodle = noodle;
        this._matchNumber = matchNumber;
        this._teamNumber = teamNumber;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_teamNumber() {
        return _teamNumber;
    }

    public void set_teamNumber(int _teamNumber) {
        this._teamNumber = _teamNumber;
    }

    public int get_matchNumber() {
        return _matchNumber;
    }

    public void set_matchNumber(int _matchNumber) {
        this._matchNumber = _matchNumber;
    }

    public int get_stackNumber() {
        return _stackNumber;
    }

    public void set_stackNumber(int _stackNumber) {
        this._stackNumber = _stackNumber;
    }

    public int get_totes() {
        return _totes;
    }

    public void set_totes(int _totes) {
        this._totes = _totes;
    }

    public int get_can() {
        return _can;
    }

    public void set_can(int _can) {
        this._can = _can;
    }

    public int get_noodle() {
        return _noodle;
    }

    public void set_noodle(int _noodle) {
        this._noodle = _noodle;
    }
}