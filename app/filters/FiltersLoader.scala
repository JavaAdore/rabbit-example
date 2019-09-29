package filters

import com.google.inject.Inject
import play.api.http.{DefaultHttpFilters, EnabledFilters}
import play.filters.gzip.GzipFilter

class FiltersLoader @Inject()(defaultFilters: EnabledFilters, log: LoggingFilter) extends DefaultHttpFilters(defaultFilters.filters :+ log: _*) {

}



