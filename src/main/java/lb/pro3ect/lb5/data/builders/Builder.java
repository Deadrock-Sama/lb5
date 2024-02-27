package lb.pro3ect.lb5.data.builders;

import lb.pro3ect.lb5.ui.UIController;


abstract public class Builder {

    public Builder(UIController controller) {
        this.controller = controller;
    }

    protected final UIController controller;

}
