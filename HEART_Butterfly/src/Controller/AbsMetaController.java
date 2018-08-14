package Controller;

import Model.AbsMetaModel;

public abstract class AbsMetaController {
	AbsMetaController parent_controller = null;
	AbsMetaModel shared_model = null;
	
	public void setParentController(AbsMetaController  parent_controller) {
		this.parent_controller = parent_controller;
	}
	
	public void setSharedModel(AbsMetaModel shared_model) {
		this.shared_model = shared_model;
	}
	
	public AbsMetaController getParentController() {
		return this.parent_controller;
	}
	
	public AbsMetaModel getSharedModel() {
		return this.shared_model;
	}
}