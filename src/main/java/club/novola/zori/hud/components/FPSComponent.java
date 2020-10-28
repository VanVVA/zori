package club.novola.zori.hud.components;

import club.novola.zori.Zori;
import club.novola.zori.hud.HudComponent;
import club.novola.zori.module.gui.FPS;
import club.novola.zori.util.Wrapper;

public class FPSComponent extends HudComponent<FPS> {
    public FPSComponent() {
        super("FPS", 2, 2, FPS.INSTANCE);
    }

    @Override
    public void renderInGui(int mouseX, int mouseY) {
        super.renderInGui(mouseX, mouseY);
            Wrapper.getFontRenderer().drawStringWithShadow("FPS", x, y, -1);
    }

    @Override
    public void render() {
        super.render();
        Wrapper.getFontRenderer().drawStringWithShadow("FPS: " +  Wrapper.mc.getDebugFPS(), x, y, Zori.getInstance().clientSettings.getColor());
        width = Wrapper.getFontRenderer().getStringWidth(Zori.getInstance().toString());
    }
}