package net.mrdino.extendedlightsmod.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.mrdino.extendedlightsmod.registry.ModBlockEntities;

public class SpotlightBlockEntity extends BlockEntity {

    private int dmxChannel = 1;       // Canal DMX asignado a este foco
    private int intensity = 255;      // 0–255
    private int red = 255, green = 255, blue = 255; // Color RGB

    public SpotlightBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SPOTLIGHT_BLOCK_ENTITY.get(), pos, state);
    }

    // Getters y setters

    public int getDmxChannel() {
        return dmxChannel;
    }

    public void setDmxChannel(int channel) {
        this.dmxChannel = channel;
    }

    public void setColor(int r, int g, int b) {
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    // Guardar datos
    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("dmxChannel", dmxChannel);
        tag.putInt("intensity", intensity);
        tag.putInt("red", red);
        tag.putInt("green", green);
        tag.putInt("blue", blue);
    }

    // Cargar datos
    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        dmxChannel = tag.getInt("dmxChannel");
        intensity = tag.getInt("intensity");
        red = tag.getInt("red");
        green = tag.getInt("green");
        blue = tag.getInt("blue");
    }
}
