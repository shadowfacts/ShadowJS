package net.shadowfacts.shadowjs.js.nbt;

import net.minecraft.nbt.NBTTagCompound;

/**
 * @author shadowfacts
 */
public class WrappedTagCompound {

	private NBTTagCompound tag;

	public WrappedTagCompound(NBTTagCompound tag) {
		this.tag = tag;
	}

	public boolean hasKey(String key) {
		return tag.hasKey(key);
	}

	public WrappedTagCompound setTagCompound(String key, WrappedTagCompound val) {
		tag.setTag(key, val.tag);
		return this;
	}

	public WrappedTagCompound setByte(String key, byte val) {
		tag.setByte(key, val);
		return this;
	}
	
	public WrappedTagCompound setShort(String key, short val) {
		tag.setShort(key, val);
		return this;
	}

	public WrappedTagCompound setInt(String key, int val) {
		tag.setInteger(key, val);
		return this;
	}

	public WrappedTagCompound setLong(String key, long val) {
		tag.setLong(key, val);
		return this;
	}

	public WrappedTagCompound setFloat(String key, float val) {
		tag.setFloat(key, val);
		return this;
	}

	public WrappedTagCompound setDouble(String key, double val) {
		tag.setDouble(key, val);
		return this;
	}

	public WrappedTagCompound setString(String key, String val) {
		tag.setString(key, val);
		return this;
	}

	public WrappedTagCompound setByteArray(String key, byte[] val) {
		tag.setByteArray(key, val);
		return this;
	}

	public WrappedTagCompound setIntArray(String key, int[] val) {
		tag.setIntArray(key, val);
		return this;
	}

	public WrappedTagCompound setBoolean(String key, boolean val) {
		tag.setBoolean(key, val);
		return this;
	}

	public WrappedTagCompound getTagCompound(String key) {
		return new WrappedTagCompound(tag.getCompoundTag(key));
	}

	public byte getByte(String key) {
		return tag.getByte(key);
	}

	public short getShort(String key) {
		return tag.getShort(key);
	}

	public int getInt(String key) {
		return tag.getInteger(key);
	}

	public long getLong(String key) {
		return tag.getLong(key);
	}

	public float getFloat(String key) {
		return tag.getFloat(key);
	}

	public double getDouble(String key) {
		return tag.getDouble(key);
	}

	public String getString(String key) {
		return tag.getString(key);
	}

	public byte[] getByteArray(String key) {
		return tag.getByteArray(key);
	}

	public int[] getIntArray(String key) {
		return tag.getIntArray(key);
	}

	public boolean getBoolean(String key) {
		return tag.getBoolean(key);
	}

	public WrappedTagCompound removeTag(String key) {
		tag.removeTag(key);
		return this;
	}



}
