package com.nekokittygames.mffs.common.blocks;

import com.nekokittygames.mffs.common.common.MFFSCreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

/**
 * Created by katsw on 03/04/2016.
 */
public abstract class MFFSBlock extends Block {

    public MFFSBlock(Material blockMaterial) {
        super(blockMaterial);
        if(ShouldRegisterInTab())
            this.setCreativeTab(MFFSCreativeTab.get());
    }

    public MFFSBlock(Material blockMaterial, MapColor blockColour) {
        super(blockMaterial, blockColour);
        if(ShouldRegisterInTab())
            this.setCreativeTab(MFFSCreativeTab.get());
    }


    public void initBlock()
    {

    }

    public  boolean ShouldRegisterInTab()
    {
        return true;
    }
}
