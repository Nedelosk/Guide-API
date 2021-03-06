package amerifrance.guideapi.entry;

import amerifrance.guideapi.api.IPage;
import amerifrance.guideapi.api.impl.Book;
import amerifrance.guideapi.api.impl.Entry;
import amerifrance.guideapi.api.impl.abstraction.CategoryAbstract;
import amerifrance.guideapi.api.util.GuiHelper;
import amerifrance.guideapi.gui.GuiBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class EntryResourceLocation extends Entry {

    public ResourceLocation image;

    public EntryResourceLocation(List<IPage> pageList, String name, ResourceLocation resourceLocation, boolean unicode) {
        super(pageList, name, unicode);
        this.image = resourceLocation;
    }

    public EntryResourceLocation(List<IPage> pageList, String name, ResourceLocation resourceLocation) {
        this(pageList, name, resourceLocation, false);
    }

    public EntryResourceLocation(String name, boolean unicode, ResourceLocation image) {
        super(name, unicode);
        this.image = image;
    }

    public EntryResourceLocation(String name, ResourceLocation image) {
        super(name);
        this.image = image;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void drawExtras(Book book, CategoryAbstract category, int entryX, int entryY, int entryWidth, int entryHeight, int mouseX, int mouseY, GuiBase guiBase, FontRenderer fontRendererObj) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(image);
        GuiHelper.drawSizedIconWithoutColor(entryX + 2, entryY, 16, 16, 1F);

        super.drawExtras(book, category, entryX, entryY, entryWidth, entryHeight, mouseX, mouseY, guiBase, fontRendererObj);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntryResourceLocation)) return false;
        if (!super.equals(o)) return false;

        EntryResourceLocation that = (EntryResourceLocation) o;

        return image != null ? image.equals(that.image) : that.image == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }
}
