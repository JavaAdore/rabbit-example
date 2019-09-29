package module

import com.google.inject.AbstractModule
import listener.TransactionListener

class StartupModule  extends AbstractModule {
  override def configure() = {

    bind(classOf[TransactionListener]).asEagerSingleton

  }

}


