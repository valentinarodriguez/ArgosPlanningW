

import org.apache.struts2.dispatcher.StreamResult;
import com.opensymphony.xwork2.ActionInvocation;

public class DynamicStreamResult extends StreamResult {

	@Override
	protected void doExecute(String finalLocation, ActionInvocation invocation) 
		throws Exception {
		
		// Obtiene el nombre del archivo desde la propiedad downloadFilename del Action correspondiente
		String downloadedFileName = "" + invocation.getStack().findValue(conditionalParse("downloadFilename", invocation));
		contentDisposition = "attachment;filename=\"" + downloadedFileName + "\"";
		
		// Obtiene el tama�o del archivo desde la propiedad downloadFilesize del Action correspondiente
		contentLength = "" + invocation.getStack().findValue(conditionalParse("downloadFilesize", invocation));
		
		// Obtiene el MIME type del archivo desde la propiedad downloadFiletype del Action correspondiente 
		contentType = "" + invocation.getStack().findValue(conditionalParse("downloadFiletype", invocation));
		
		super.doExecute(finalLocation, invocation);
	}
}
