package simulation.adt.physics_value3d.classes;

import java.util.Objects;
import simulation.adt.phsyics_value3d.interfaces.BoundingBox;
import simulation.adt.physics_value.interfaces.Length;

public class BoundingBoxImpl implements BoundingBox{
    
    //Var
    Length width;
    Length height;
    Length length;
    
    //Constructor
    private BoundingBoxImpl(Length width, Length height, Length length) {
        this.width = width;
        this.height = height;
        this.length = length;        
    }
    
    //Factory
    public static BoundingBox valueOf(Length width, Length height, Length length) {
        return new BoundingBoxImpl(width,height,length);
    }

    @Override
    public Length width() {
        return width;
    }

    @Override
    public Length height() {
        return height;
    }

    @Override
    public Length length() {
        return length;
    }
    
    //Boolean
    public boolean checkInstance(Object other) {
         return other instanceof BoundingBox;
    }
    
    @Override
    public boolean fitsInto(BoundingBox other) {
        if(width.value()  < other.width().value() &&
           height.value() < other.height().value()&& 
           length.value() < other.length().value()) {
           return true;
        }
        return false;
    }

    //Hash&Equal
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.width);
        hash = 97 * hash + Objects.hashCode(this.height);
        hash = 97 * hash + Objects.hashCode(this.length);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BoundingBoxImpl other = (BoundingBoxImpl) obj;
        if (!Objects.equals(this.width, other.width)) {
            return false;
        }
        if (!Objects.equals(this.height, other.height)) {
            return false;
        }
        if (!Objects.equals(this.length, other.length)) {
            return false;
        }
        return true;
    }
        
    //toString
    @Override
    public String toString() {
        return toString_EU();
    }
   
    public String toString_EU() {
        String text = this.length.value()+"m "+this.width.value()+"m "+this.height.value()+"m" ;
        return text;
    }
}
