package fr.wolfdev.mineorm.orm;

import net.minecraft.nbt.NBTTagCompound;

public interface INBTSerializable<T>
{
    @SuppressWarnings("unchecked")
    default void genericWrite(NBTTagCompound tag, String key, Object value) {
        this.write(tag, key, (T)value);
    }
    void write(NBTTagCompound tag, String key, T value);
    T read(NBTTagCompound tag, String key);
}
