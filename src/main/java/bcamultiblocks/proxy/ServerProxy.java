package bcamultiblocks.proxy;

public class ServerProxy extends CommonProxy {

	@Override
	public void preInit() {
		super.preInit();
	}

	@Override
	public void init() {
		super.postInit();
	}

	@Override
	public void postInit() {
		super.init();
	}
}
