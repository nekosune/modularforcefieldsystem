package net.newgaea.mffs.client.gui.buttons;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.newgaea.mffs.common.inventory.CapacitorContainer;
import net.newgaea.mffs.common.inventory.NetworkContainer;
import net.newgaea.mffs.common.libs.LibMisc;
import org.lwjgl.opengl.GL11;

public class ButtonSwitch extends Button {
    private final int SWITCH_MODE_TEXTURE_SIZE = 96;
    public final ResourceLocation SWITCH_MODE_TEXTURE=new ResourceLocation(LibMisc.MOD_ID, "textures/gui/buttons/switch_modes.png");
    private ContainerScreen parent;
    public ButtonSwitch(ContainerScreen parent,int x, int y, IPressable pressedAction) {
        super(x, y, 16,16, new StringTextComponent(""), pressedAction);
        this.parent=parent;

    }

    private void drawButtonRect(MatrixStack matrixStack,int x,int y, int frameX, int frameY, int width, int height) {
        double uvMult = 1.0 / SWITCH_MODE_TEXTURE_SIZE;
        Tessellator tessellator =Tessellator.getInstance();
        BufferBuilder bufferBuilder=tessellator.getBuffer();
        bufferBuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(x,y+height,1).tex((float)(frameX*uvMult),(float)((frameY+height)*uvMult)).endVertex();
        bufferBuilder.pos(x+width,y+height,1).tex((float)((frameX+width)*uvMult),(float)((frameY+height)*uvMult)).endVertex();
        bufferBuilder.pos(x+width,y,1).tex((float)((frameX+width)*uvMult),(float)((frameY)*uvMult)).endVertex();
        bufferBuilder.pos(x,y,1).tex((float)(frameX*uvMult),(float)((frameY)*uvMult)).endVertex();
        tessellator.draw();

    }
    @Override
    public void renderButton(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.renderButton(matrixStack, mouseX, mouseY, partialTicks);
        Minecraft.getInstance().getRenderManager().textureManager.bindTexture(SWITCH_MODE_TEXTURE);
        drawButtonRect(matrixStack,x,y,((NetworkContainer)parent.getContainer()).getMode().ordinal()*16,0,this.width,this.height);

    }
}