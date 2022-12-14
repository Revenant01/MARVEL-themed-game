package Conroller;

import javax.swing.PopupFactory;

import engine.Game;
import engine.Player;
import views.EntryView;
import views.NamesFrame;
import views.PopupView;
import views.BoardView;
import views.ChampionsSelectionView;
import views.moveview;
import views.normalabilityview;
import views.attackview;
import views.mainabilityview;
import views.directionalabilityview;
import views.singleabilityview;
public class Controller
{
	private EntryView entryView;
	private NamesFrame namesframe;
	private ChampionsSelectionView championsSelectionView;
	private moveview moveview;
	private static Game game;
	private BoardView boardView;
	private attackview attackview;
	private mainabilityview mainabilityview;
	private normalabilityview normalabilityview;
	private directionalabilityview directionalabilityview;
	private singleabilityview singleabilityview;
	private boolean flag;
	
	public NamesFrame getNamesframe() {
		return namesframe;
	}

	public void setNamesframe(NamesFrame namesframe) {
		this.namesframe = namesframe;
	}

	public ChampionsSelectionView getChampionsSelectionView() {
		return championsSelectionView;
	}

	public void setChampionsSelectionView(ChampionsSelectionView championsSelectionView) {
		this.championsSelectionView = championsSelectionView;
	}

	 
	public Controller()
	{
		EntryView entryView = new EntryView();
		entryView.setController(this);
	}
	
	public static void main(String[] args)
	{
		Controller controller = new Controller();
	}
	
	public void toNamesFrame()
	{
		
		NamesFrame namesFrame = new NamesFrame(this);
		//game = (namesFrame.getGame2());
		namesFrame.setController(this);
		namesFrame.setVisible(true);
	}
	public void toChampionsSelectionView()
	{
		ChampionsSelectionView championsSelectionView = new ChampionsSelectionView(this);
		championsSelectionView.setController(this);
		championsSelectionView.setVisible(true);
	}
	
	public void toBoardView()
	{
		if(flag==false) {
	     getGame().placeChampions();
		flag=true;}
		BoardView boardView = new BoardView(this);
		boardView.setController(this);
		boardView.setVisible(true);
		
	}
	public void topopup(String s) {
		new PopupView(s);
	}
	public void tomoveview(BoardView view) {
		moveview moveview=new moveview(this,view);
		moveview.setController(this);
		moveview.setVisible(true);
	}
	public void toattackview(BoardView view) {
		attackview attackview=new attackview(this,view);
		attackview.setController(this);
		attackview.setVisible(true);
	}
	public void tomainabilityview(BoardView view) {
		mainabilityview mainabilityview=new mainabilityview(this, view);
		mainabilityview.setController(this);
		mainabilityview.setVisible(true);
	}
	public void tonormalbilityview(BoardView v) {
		normalabilityview normalabilityview=new normalabilityview(this,v);
		normalabilityview.setController(this);
		normalabilityview.setVisible(true);
	}
	public void todirectionalbilityview(BoardView v) {
		directionalabilityview directionalabilityview=new directionalabilityview(this,v);
		directionalabilityview.setController(this);
		directionalabilityview.setVisible(true);
	}
	public void tosinglebilityview(BoardView v) {
		singleabilityview singleabilityview=new singleabilityview(this,v);
		singleabilityview.setController(this);
		singleabilityview.setVisible(true);
	}
	public moveview getmoveview() {
		return moveview;
	}

	public void setmoveview(moveview moveview) {
		this.moveview = moveview;
	}
	public attackview getattackview() {
		return attackview;
	}
	public void setattackview(attackview attackview) {
		this.attackview = attackview;
	}
	public mainabilityview getmainabilityview() {
		return mainabilityview;
	}
	public void setmainabilityview(mainabilityview mainabilityview) {
		this.mainabilityview=mainabilityview;
	}
	public normalabilityview getnormalabilityview() {
		return normalabilityview;
	}
	public void setnormalabilityview(normalabilityview normalabilityview) {
		this.normalabilityview=normalabilityview;
	}
	public directionalabilityview getdirectionalabilityview() {
		return directionalabilityview;
	}
	public void setdirectionalabilityview(directionalabilityview directionalabilityview) {
		this.directionalabilityview=directionalabilityview;
	}
	public EntryView getEntryView() {
		return entryView;
	}

	public void setEntryView(EntryView entryView) {
		this.entryView = entryView;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
}
