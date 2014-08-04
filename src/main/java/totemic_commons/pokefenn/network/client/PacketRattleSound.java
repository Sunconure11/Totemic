package totemic_commons.pokefenn.network.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Pokefenn.
 * Licensed under MIT (If this is one of my Mods)
 */
public class PacketRattleSound implements IMessage, IMessageHandler<PacketRattleSound, IMessage>
{
    public int x, y, z;

    public PacketRattleSound()
    {

    }

    public PacketRattleSound(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
    }

    @Override
    public IMessage onMessage(PacketRattleSound message, MessageContext ctx)
    {
        EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;

        player.worldObj.playSound(message.x, message.y, message.z, "totemic:rattle", 0.8F, 1.0F, false);

        return null;
    }
}
