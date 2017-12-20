class Checker implements Comparator<Player>
{
    public int compare(Player p1, Player p2)
    {
        if(p1.score != p2.score)
            return p1.score > p2.score ? -1 : (p1.score == p2.score ? 0 : 1);
        else
            return p1.name.compareTo(p2.name);
    }
}