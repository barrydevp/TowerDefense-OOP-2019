package mrmathami.thegame.field.characteristic;

import mrmathami.thegame.field.GameEntity;
import mrmathami.thegame.field.GameField;

//import javax.annotation.Nonnull;

public interface DestroyableEntity extends GameEntity {
	void doDestroy();

	boolean isDestroyed();

	interface DestroyListener extends DestroyableEntity {
		void onDestroy( GameField field, int tickCount);
	}
}

