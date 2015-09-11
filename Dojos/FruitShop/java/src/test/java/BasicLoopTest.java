import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class BasicLoopTest {


    @Test
    public void should_handle_input() {
        assertThat(new BasicLoop().doSomethingWithInput("foobar")).isEqualTo("< foobar");
    }
    
    @Test
    public void doit_enregistrer_pommes() {
    	String out = new BasicLoop().doSomethingWithInput("pommes");
		assertThat(out ).isEqualTo("< 100");
    }
    
    @Test
    public void doit_enregistrer_cerises() {
    	String out = new BasicLoop().doSomethingWithInput("cerises");
		assertThat(out).isEqualTo("< 75");
    }
    
    @Test
    public void doit_enregistrer_bananes() {
    	String out = new BasicLoop().doSomethingWithInput("bananes");
		assertThat(out ).isEqualTo("< 150");
    }

    @Test
    public void doit_cumuler_panier_simple() {
    	BasicLoop basicLoop = new BasicLoop();
		String out = basicLoop.doSomethingWithInput("pommes");
    	out = basicLoop.doSomethingWithInput("cerises");
		assertThat(out ).isEqualTo("< 175");
    }

    @Test
    public void doit_remiser_cerises() {
    	BasicLoop basicLoop = new BasicLoop();
    	String out = basicLoop.doSomethingWithInput("pommes");
		out = basicLoop.doSomethingWithInput("cerises");
    	out = basicLoop.doSomethingWithInput("cerises");
		assertThat(out ).isEqualTo("< 230");
    	
    }
    
    @Test
    public void doit_remiser_bananes() {
    	BasicLoop basicLoop = new BasicLoop();
    	String out = basicLoop.doSomethingWithInput("cerises");
    	out = basicLoop.doSomethingWithInput("cerises");
		out = basicLoop.doSomethingWithInput("Bananes");
    	out = basicLoop.doSomethingWithInput("Bananes");
		assertThat(out ).isEqualTo("< 280");
    	
    }
    @Test
    public void doit_remiser_cerises_2_fois() {
    	BasicLoop basicLoop = new BasicLoop();
    	String out = basicLoop.doSomethingWithInput("cerises");
    	out = basicLoop.doSomethingWithInput("pommes");
    	out = basicLoop.doSomethingWithInput("cerises");
		out = basicLoop.doSomethingWithInput("bananes");
    	out = basicLoop.doSomethingWithInput("cerises");
    	out = basicLoop.doSomethingWithInput("cerises");
    	out = basicLoop.doSomethingWithInput("pommes");
		assertThat(out ).isEqualTo("< 410");
    }
    
    @Test
    public void doit_accepter_une_liste_articles() {
    	BasicLoop basicLoop = new BasicLoop();
    	String out = basicLoop.doSomethingWithInput("Pommes, Cerises, Bananes");
		assertThat(out ).isEqualTo("< 325");
    	
    }
    
    @Test
    public void doit_remiser_panier_complexe() {
    	BasicLoop basicLoop = new BasicLoop();
    	String out = basicLoop.doSomethingWithInput("cerises");
    	out = basicLoop.doSomethingWithInput("pommes");
    	out = basicLoop.doSomethingWithInput("cerises");
		out = basicLoop.doSomethingWithInput("bananes");
		out = basicLoop.doSomethingWithInput("pommes");
		out = basicLoop.doSomethingWithInput("bananes");
    	out = basicLoop.doSomethingWithInput("cerises");
		assertThat(out ).isEqualTo("< 355");
    }
    
    @Test
    public void doit_supporter_la_localisation_pour_pommes() {
    	BasicLoop basicLoop = new BasicLoop();
    	String out = basicLoop.doSomethingWithInput("cerises");
    	out = basicLoop.doSomethingWithInput("Apples");
    	out = basicLoop.doSomethingWithInput("cerises");
		out = basicLoop.doSomethingWithInput("bananes");
		out = basicLoop.doSomethingWithInput("bananes");
		assertThat(out ).isEqualTo("< 180");
    }
    
    @Test
    public void doit_supporter_la_localisation_pour_pommes_europeennes() {
    	BasicLoop basicLoop = new BasicLoop();
    	String out = basicLoop.doSomethingWithInput("cerises");
    	out = basicLoop.doSomethingWithInput("Apples");
    	out = basicLoop.doSomethingWithInput("cerises");
		out = basicLoop.doSomethingWithInput("bananes");
		out = basicLoop.doSomethingWithInput("Pommes");
		out = basicLoop.doSomethingWithInput("mele");
		assertThat(out ).isEqualTo("< 380");
    }
    
    @Test
    @Ignore
    public void doit_supporter_la_remise_par_article() {
    	BasicLoop basicLoop = new BasicLoop();
    	String out = basicLoop.doSomethingWithInput("mele");
		assertThat(out ).isEqualTo("< 100");
    	out = basicLoop.doSomethingWithInput("Apples");
		assertThat(out ).isEqualTo("< 200");
    	out = basicLoop.doSomethingWithInput("apples");
		assertThat(out ).isEqualTo("< 300");
		out = basicLoop.doSomethingWithInput("Pommes");
		assertThat(out ).isEqualTo("< 400");
		out = basicLoop.doSomethingWithInput("apples");
		assertThat(out ).isEqualTo("< 400");
		out = basicLoop.doSomethingWithInput("mele");
		assertThat(out ).isEqualTo("< 450");
    	out = basicLoop.doSomethingWithInput("cerises");
		assertThat(out ).isEqualTo("< 525");
    	out = basicLoop.doSomethingWithInput("cerises");
		assertThat(out ).isEqualTo("< 580");
    }
    
    @Test
    public void doit_supporter_la_remise_par_article_hard() {
    	BasicLoop basicLoop = new BasicLoop();
    	String out = basicLoop.doSomethingWithInput("mele");
    	out = basicLoop.doSomethingWithInput("Apples");
    	out = basicLoop.doSomethingWithInput("apples");
		out = basicLoop.doSomethingWithInput("Pommes");
		out = basicLoop.doSomethingWithInput("apples");
		out = basicLoop.doSomethingWithInput("mele");
    	out = basicLoop.doSomethingWithInput("cerises");
    	out = basicLoop.doSomethingWithInput("cerises");
    	out = basicLoop.doSomethingWithInput("bananes");
		assertThat(out ).isEqualTo("< 380");
    }
    
    @Test
    @Ignore
    public void doit_supporter_la_remise_par_article_hard_integre() {
    	BasicLoop basicLoop = new BasicLoop();
    	String out = basicLoop.doSomethingWithInput("Cerises,Apples");
		assertThat(out ).isEqualTo("< 175");
    	out = basicLoop.doSomethingWithInput("Cerises");
		assertThat(out ).isEqualTo("< 230");
    	out = basicLoop.doSomethingWithInput("apples");
		assertThat(out ).isEqualTo("< 680");
		out = basicLoop.doSomethingWithInput("Pommes");
		assertThat(out ).isEqualTo("< 680");
		out = basicLoop.doSomethingWithInput("apples");
		assertThat(out ).isEqualTo("< 680");
		out = basicLoop.doSomethingWithInput("mele");
		assertThat(out ).isEqualTo("< 680");
    	out = basicLoop.doSomethingWithInput("cerises");
		assertThat(out ).isEqualTo("< 680");
    	out = basicLoop.doSomethingWithInput("cerises");
		assertThat(out ).isEqualTo("< 680");
    	out = basicLoop.doSomethingWithInput("bananes");
		assertThat(out ).isEqualTo("< 680");
    }
    
    @Test
    public void doit_supporter_la_remise_globale() {
    	BasicLoop basicLoop = new BasicLoop();
    	String out = basicLoop.doSomethingWithInput("Mele, Apples, Apples, Mele");
		assertThat(out ).isEqualTo("< 200");
    	out = basicLoop.doSomethingWithInput("Bananes");
		assertThat(out ).isEqualTo("< 150");
    	out = basicLoop.doSomethingWithInput("Mele, apples, Apples, Pommes, Mele");
		assertThat(out ).isEqualTo("< 150");
    }
 }