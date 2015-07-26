package net.leidra.vaadinmdl.components;

public class MDLComponentConstants {
	public enum MDLStyles {
		RAISED, FAB;
		
    	@Override
		public String toString() {
			return name().toLowerCase();
		}
	};
	
    public enum MDLColor {
    	COLORED, ACCENT;

    	public MDLColor retrieveVariant() {
    		return COLORED.equals(this) ? ACCENT : COLORED;
    	}
    	
    	@Override
    	public String toString() {
    		return name().toLowerCase();
    	}
    };
    
    public enum MDLEffects {
    	RIPPLE("mdl-js-ripple-effect");
    	private String name;
    	
    	private MDLEffects(String name) {
    		this.name = name;
    	}
    	
    	@Override
    	public String toString() {
    		return name.toLowerCase();
    	}
    };
    
}