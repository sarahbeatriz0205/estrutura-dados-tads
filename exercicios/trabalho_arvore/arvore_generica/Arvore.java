package arvore_generica;

public class Arvore{
	
	No raiz;
	int tamanho;

	public Arvore(Object o){
		raiz = new No(null, o);
		tamanho = 1;
	}

	public No root(){
		return this.raiz;
	}

	public No parent(No v){
		return v.getPai();
	}

	public Iterator children(No v){
		return v.children();
	}

	public boolean isInternal(No v){
		if (v.childrenNumber() != 0){
			return true;
		}
		return false;
	}
	
	public boolean isExternal(No v){
		if (v.childrenNumber() == 0){
			return true;
		}
		return false;
	}

	public boolean isRoot(No v){
		if (v == root()){
			return true;
		}
		return false;
	}

	public void addChild(No v, Object o){
		No novo = new No(v, o);
		v.addChild(novo);
		this.tamanho++;
	}

	/** Remove um No
	 *  S� pode remover Nos externos e que tenham um pai (n�o seja raiz)
	*/
	public Object remove(No v) throws ArvoreExcecao{
		No pai = v.parent();
		if (pai != null || isExternal(v))
			pai.removeChild(v);
		else
			throw new ArvoreExcecao("Nó inválido");
		Object o = v.element();
		tamanho--;
		return o;
	}

	public int depth(No v){
		return profundidade(v);
	}

	private int profundidade(No v){
		if (v == raiz)
			return 0;
		else
			return 1 + profundidade(v.parent());
	}

	public int height(No v){
		return altura(v);
	}

	private int altura(No v){
		if (isExternal(v)){
			return 0;
		} else {
			int h = 0;
			for (Object f : v.children()){
				h = Math.max(h, altura(f));
			}
			return 1+h;
		}
	}

	public int size(){
		return this.tamanho;
	}

	/** Sempre vai ser falso, pois não permitimos remover a raiz */
	public boolean isEmpty(){
		return false;
	}

	private void visite(No v){
		System.out.println(v.element())
	}

	public void preOrder(No v){
		visite(v);
		for (Object f : v.children()){
			preOrder(f);
		}
	}

	public void postOrder(No v){
		for (Object f : v.children()){
			postOrder(f);
		}
		visite(v);
	}

	public Object replace(No v, Object o){
		No e = v.element();
		v.setElement(o);
		return e;
	}

	public Iterator elements(){
		
		return null;
	}

	/** Retorna um iterator com as posi��es (Nos) da �rvore */
	public Iterator Nos(){
		// M�todo que serve de exerc�cio
		return null;
	}

	/** Troca dois elementos de posi��o */
	public void swapElements(No v, No w){
		/*M�todo que serve de exerc�cio
		 * Este m�todo dever� fazer com que o objeto
		 * que estava na posi��o v fique na posi��o w
		 * e fazer com que o objeto que estava na posi��o w
		 * fique na posi��o v
		 */  
	}