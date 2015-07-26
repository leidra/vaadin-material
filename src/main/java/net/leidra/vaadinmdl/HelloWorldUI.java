package net.leidra.vaadinmdl;

import javax.servlet.annotation.WebServlet;

import net.leidra.vaadinmdl.components.Button;
import net.leidra.vaadinmdl.components.MDLComponentConstants.MDLColor;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Widgetset("net.leidra.MyAppWidgetset")
@StyleSheet({
	"https://storage.googleapis.com/code.getmdl.io/1.0.1/material.indigo-blue.min.css", 
	"https://fonts.googleapis.com/icon?family=Material+Icons"	
})
@com.vaadin.annotations.JavaScript("https://storage.googleapis.com/code.getmdl.io/1.0.1/material.min.js")
@Theme(net.leidra.vaadinmdl.HelloWorldUI.THEME_NAME)
public class HelloWorldUI extends UI {
	private static final long serialVersionUID = 1L;
	public static final String THEME_NAME = "mytheme";

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		Page.getCurrent().setTitle("Vaadin MDL Integration");
		
		final VerticalLayout layout = createRootLayout();
		setContent(layout);

		final TextField textField = createMDLTextField(layout);
		
		createMDLButton(layout, textField);
		
		JavaScript.getCurrent().execute("dispatchEvent(new Event('load'));");		
	}

	private VerticalLayout createRootLayout() {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSizeFull();
		return layout;
	}

	private void createMDLButton(final VerticalLayout layout, final TextField textField) {
		Button button = new Button("Click Me");
		button.raise();
		button.ripple();
		button.setColor(MDLColor.COLORED);
		button.addClickListener(event -> {
			layout.addComponent(new Label("Hello " + textField.getValue()), 2);
		});

		layout.addComponent(button);
	}

	private TextField createMDLTextField(final VerticalLayout layout) {
		// Create a MDL text field component (http://www.getmdl.io/components/index.html#textfields-section)
		CssLayout textFieldContainer = new CssLayout();
		textFieldContainer.setStyleName("mdl-textfield mdl-js-textfield mdl-textfield--floating-label");
		
		Label textFieldLabel = new Label("Username: ");
		textFieldLabel.setStyleName("mdl-textfield__label");

		final TextField textField = new TextField();
		textField.setStyleName("mdl-textfield__input");

		textFieldContainer.addComponent(textField, 0);
		textFieldContainer.addComponent(textFieldLabel, 1);
		layout.addComponent(textFieldContainer);
		return textField;
	}

	@WebServlet(urlPatterns = "/*", name = "HelloWorldServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = HelloWorldUI.class, productionMode = false)
	public static class HelloWorldServlet extends VaadinServlet {
		private static final long serialVersionUID = 1L;
	}
}