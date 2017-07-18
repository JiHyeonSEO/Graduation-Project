package PDB.PDB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class PostBLASTQuery {

   public static final String SERVICELOCATION="http://www.rcsb.org/pdb/rest/postBLAST";
   
   public PostBLASTQuery(String seq)
   {
	      //String param1 = "sequence=MRHIAHTQRCLSRLTSLVALLLIVLPMVFSPAHSCGPGRGLGRHRARNLYPLVLKQTIPNLSEYTNSASGPLEGVIRRDSPKFKDLVPNYNRDILFRDEEGTGADRLMSKRCKEKLNVLAYSVMNEWPGIRLLVTESWDEDYHHGQESLHYEGRAVTIATSDRDQSKYGMLARLAVEAGFDWVSYVSRRHIYCSVKSDSSISSHVHGCFTPESTALLESGVRKPLGELSIGDRVLSMTANGQAVYSEVILFMDRNLEQMQNFVQLHTDGGAVLTVTPAHLVSVWQPESQKLTFVFADRIEEKNQVLVRDVETGELRPQRVVKVGSVRSKGVVAPLTREGTIVVNSVAASCYAVINSQSLAHWGLAPMRLLSTLEAWLPAKEQLHSSPKVVSSAQQQNGIHWYANALYKVKDYVLPQSWRHD";
	   	  //String param1 = "sequence=MDRDSLPRVPDTHGDVVDEKLFSDLYIRTSWVDAQVALDQIDKGKARGSRTAIYLRSVFQSHLETLGSSVQKHAGKVLFVAILVLSTFCVGLKSAQIHSKVHQLWIQEGGRLEAELAYTQKTIGEDESATHQLLIQTTHDPNASVLHPQALLAHLEVLVKATAVKVHLYDTEWGLRDMCNMPSTPSFEGIYYIEQILRHLIPCSIITPLDCFWEGSQLLGPESAVVIPGLNQRLLWTTLNPASVMQYMKQKMSEEKISFDFETVEQYMKRAAIGSGYMEKPCLNPLNPNCPDTAPNKNSTQPPDVGAILSGGCYGYAAKHMHWPEELIVGGAKRNRSGHLRKAQALQSVVQLMTEKEMYDQWQDNYKVHHLGWTQEKAAEVLNAWQRNFSREVEQLLRKQSRIATNYDIYVFSSAALDDILAKFSHPSALSIVIGVAVTVLYAFCTLLRWRDPVRGQSSVGVAGVLLMCFSTAAGLGLSALLGIVFNAASTQVVPFLALGLGVDHIFMLTAAYAESNRREQTKLILKKVGPSILFSACSTAGSFFAAAFIPVPALKVFCLQAAIVMCSNLAAALLVFPAMISLDLRRRTAGRADIFCCCFPVWKEQPKVAPPVLPLNNNNGRGARHPKSCNNNRVPLPAQNPLLEQRADIPGSSHSLASFSLATFAFQHYTPFLMRSWVKFLTVMGFLAALISSLYASTRLQDGLDIIDLVPKDSNEHKFLDAQTRLFGFYSMYAVTQGNFEYPTQQQLLRDYHDSFVRVPHVIKNDNGGLPDFWLLLFSEWLGNLQKIFDEEYRDGRLTKECWFPNASSDAILAYKLIVQTGHVDNPVDKELVLTNRLVNSDGIINQRAFYNYLSAWATNDVFAYGASQGKLYPEPRQYFHQPNEYDLKIPKSLPLVYAQMPFYLHGLTDTSQIKTLIGHIRDLSVKYEGFGLPNYPSGIPFIFWEQYMTLRSSLAMILACVLLAALVLVSLLLLSVWAAVLVILSVLASLAQIFGAMTLLGIKLSAIPAVILILSVGMMLCFNVLISLGFMTSVGNRQRRVQLSMQMSLGPLVHGMLTSGVAVFMLSTSPFEFVIRHFCWLLLVVLCVGACNSLLVFPILLSMVGPEAELVPLEHPDRISTPSPLPVRSSKRSGKSYVVQGSRSSRGSCQKSHHHHHKDLNDPSLTTITEEPQSWKSSNSSIQMPNDWTYQPREQRPASYAAPPPAYHKAAAQQHHQHQGPPTTPPPPFPTAYPPELQSIVVQPEVTVETTHSDSNTTKVTATANIKVELAMPGRAVRSYNFTS";
	      String param1 = "seq";
	      String param2 = "eCutOff=10.0";
	      String param3 = "matrix=BLOSUM62"; 
	      String param4 = "outputFormat=XML";  // HTML or XML. If not specified, default to plain text 
	      //String fileName = "C:\\test.xml";
	      
	      try
	      {
	         // Send the request 
	         URL url = new URL(SERVICELOCATION);
	         URLConnection conn = url.openConnection();
	         conn.setDoOutput(true);
	         BufferedWriter out = new BufferedWriter( new OutputStreamWriter( conn.getOutputStream()) );
	            
	         // Write parameters 
	         out.write(param1);
	         out.write("&");
	         out.write(param2);
	         out.write("&");
	         out.write(param3);
	         out.write("&");
	         out.write(param4);
	         out.flush();
	         out.close();
	         
	         // Get the response
	         StringBuffer answer = new StringBuffer();
	         BufferedReader in = new BufferedReader( new InputStreamReader( conn.getInputStream()) );
	         String line;
	       
	         while ( (line = in.readLine()) != null ) {
	            answer.append(line);
	         }
	         in.close();
	       
	         FileWriter output = new FileWriter(new File("test.xml"));
	          //Output the response
	         System.out.println(answer.toString());
	         output.write(answer.toString());
	         output.close();
	      }
	      catch(FileNotFoundException e)
	      {
	    	  e.getMessage();
	      }
	      catch (Exception ex) 
	      {
	         ex.printStackTrace();
	      }
   }
}  
