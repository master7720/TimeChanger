public class TimeChanger extends Module {
    public TimeChanger() {
        super("TimeChanger", Category.WORLD);
    }

    public NumSetting time = register(new NumSetting("Time", 18000, 0, 24000));

    @SubscribeEvent
    public void onUpdate(TickEvent.ClientTickEvent event) {
        if(nullCheck()) return;
        mc.world.setWorldTime((long) time.getValue());
    }

    @SubscribeEvent
    public void onTimeUpdate(PacketEvent.Receive event) {
        if(event.getPacket() instanceof SPacketTimeUpdate) {
            event.setCanceled(true);
        }
    }
}
