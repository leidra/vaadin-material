package net.leidra.vaadinmdl.components;

import net.leidra.vaadinmdl.components.MDLComponentConstants.MDLColor;
import net.leidra.vaadinmdl.components.MDLComponentConstants.MDLEffects;
import net.leidra.vaadinmdl.components.MDLComponentConstants.MDLStyles;
import com.vaadin.server.Resource;
import com.vaadin.ui.JavaScript;

public class Button extends com.vaadin.ui.Button {
	private static final long serialVersionUID = -4649268359828877226L;
	private static final String STYLE_NAME = "mdl-button";

	public Button() {
		super();
		init();
	}

	public Button(Resource icon) {
		super(icon);
		init();
	}

	public Button(String caption, ClickListener listener) {
		super(caption, listener);
		init();
	}

	public Button(String caption, Resource icon) {
		super(caption, icon);
		init();
	}

	public Button(String caption) {
		super(caption);
		init();
	}

	private void init() {
		this.setId("button-" + java.util.Calendar.getInstance().getTimeInMillis());
		setStyleName(STYLE_NAME + " mdl-js-button");
		
		// MDL button click listener. Force button blur event to be caught by MDL
		this.addClickListener(e -> {
			String mdlButtonClickJavascript = "document.getElementById('" + e.getButton().getId() + "').blur();";
			JavaScript.getCurrent().execute(mdlButtonClickJavascript);
		});
	}
	
	public void ripple() {
		addStyleName(MDLEffects.RIPPLE);
	}
	
	public void raise() {
		addStyleName(MDLStyles.RAISED);
	}
	
	public void fab() {
		addStyleName(MDLStyles.FAB);
	}

	public void setColor(MDLColor color) {
		removeStyleName(color.retrieveVariant().toString());
		addStyleName(color.toString());
	}
	
	private void addStyleName(MDLStyles style) {
		addStyleName(style.toString());
	}

	private void addStyleName(MDLEffects effect) {
		super.addStyleName(effect.toString());
	}

	@Override
	public void addStyleName(String style) {
		super.addStyleName(STYLE_NAME + "--" + style);
	}
	
	@Override
	public void removeStyleName(String style) {
		super.removeStyleName(STYLE_NAME + "--" + style);
	}
	
}