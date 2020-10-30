package club.novola.zori.module.render;

import club.novola.zori.setting.Setting;
import club.novola.zori.module.Module;
import club.novola.zori.util.Wrapper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NoRender extends Module {
    public NoRender() {
        super("NoRender", Category.RENDER);
    }

    private Setting<Boolean> armorBar = register("ArmorBar", true);
    private Setting<Boolean> rain = register("Rain", true);

    @SubscribeEvent
    public void preRenderGameOverlay(RenderGameOverlayEvent.Pre event){
        if(event.getType().equals(RenderGameOverlayEvent.ElementType.ARMOR) && armorBar.getValue()){
            event.setCanceled(true);
        }
        if(rain.getValue()){
            Wrapper.INSTANCE.getWorld().setRainStrength(0.0f);
        }
    }
}