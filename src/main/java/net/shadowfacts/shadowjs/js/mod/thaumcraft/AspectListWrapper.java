package net.shadowfacts.shadowjs.js.mod.thaumcraft;

import lombok.ToString;
import thaumcraft.api.aspects.AspectList;

import java.util.LinkedHashMap;

/**
 * @author shadowfacts
 */
public class AspectListWrapper {

	public LinkedHashMap<AspectWrapper, Integer> aspects = new LinkedHashMap<AspectWrapper,Integer>();

	private AspectListWrapper() {

	}

	public AspectListWrapper add(AspectWrapper aspect, int amount) {
		if (this.aspects.containsKey(aspect)) {
			int oldamount = this.aspects.get(aspect);
			amount += oldamount;
		}
		this.aspects.put( aspect, amount );
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("AspectListWrapper(aspects=");

		aspects.forEach((a, i) -> {
			builder.append(String.format("(%s, %d), ", a, i));
		});

		builder.delete(builder.length() - 2, builder.length());
		builder.append(")");

		return builder.toString();
	}

	AspectList unwrap() {
		AspectList list = new AspectList();
		aspects.forEach((a, i) -> list.add(a.unwrap(), i));
		return list;
	}

	public static AspectListWrapper of(Object... params) {
		if (params.length % 2 != 0) {
			throw new IllegalArgumentException("Invalid number of aspect/amounts");
		}

		AspectListWrapper list = new AspectListWrapper();
		for (int i = 0; i < params.length; i += 2) {
			AspectWrapper aspect;
			Integer amount;

			if (params[i] instanceof AspectWrapper) {
				aspect = (AspectWrapper)params[i];
			} else if (params[i] instanceof String) {
				aspect = AspectWrapper.of((String)params[i]);
			} else {
				throw new IllegalArgumentException(String.format("Argument %d must be an aspect or aspect id", i));
			}

			if (params[i + 1] instanceof Integer) {
				amount = (Integer)params[i + 1];
			} else {
				throw new IllegalArgumentException(String.format("Argument %d must be an integer", i + 1));
			}

			list.add(aspect, amount);
		}

		return list;
	}


}
