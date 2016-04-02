package net.shadowfacts.shadowjs.js.mod.thaumcraft;

import lombok.ToString;
import thaumcraft.api.aspects.Aspect;

/**
 * @author shadowfacts
 */
@ToString
public class AspectWrapper {

	private Aspect aspect;

	private AspectWrapper(Aspect aspect) {
		this.aspect = aspect;
	}

	Aspect unwrap() {
		return aspect;
	}

	public static AspectWrapper of(Aspect aspect) {
		return new AspectWrapper(aspect);
	}

	public static AspectWrapper of(String id) {
		return of(Aspect.getAspect(id));
	}

}
