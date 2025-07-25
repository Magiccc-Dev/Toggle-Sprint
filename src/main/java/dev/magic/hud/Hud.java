
package dev.magic.hud;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.text.Style;

public class Hud {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private boolean isSprintToggled = false;

    public void register() {
        HudRenderCallback.EVENT.register(this::renderSprintStatus);
    }

    public void showStatus(boolean toggled) {
        this.isSprintToggled = toggled;
    }

    private void renderSprintStatus(DrawContext drawContext, float tickDelta) {
        if (!isSprintToggled || mc == null || mc.textRenderer == null) {
            return;
        }

        int x = 10;
        int y = 10;

        Text textToRender = Text.literal("Sprint Toggled").setStyle(Style.EMPTY);
        drawContext.drawTextWithShadow(mc.textRenderer, textToRender, x, y, 0xFFFFFF);
    }
}
