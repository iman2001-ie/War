from Card import Card
from Deck import Deck
from Player import Player


class Game:
    """Game class"""
    def explain_game(self) -> None:
        note: str = \
"""
Welome to the War card-game!!!
------------------------------

Game Overview:

War is a classic two-player card game that is simple yet exciting. 
The objective is to win the most number of rounds!


1. Pre-game Notes:

   - The Ace is the highest-ranked card in this game.
   - The suits are ranked differently as well. Here are the suits from 
     strongest to weakest:
     
          clubs - 4 points
          diamonds - 3 points
          hearts - 2 points
          spades - 1 point
  

2. Setup:

   - A standard 52-card deck is divided equally between two players.
   - Each player receives their own stack of cards, face down.



3. Gameplay:

   The Deal:
   
   - Players simultaneously reveal the top card of their stack.
   - The player with the higher-ranked card(the higher-number card) 
     wins that round of the game. 
     
   Ties("War"):
   
   - If the revealed cards are of equal rank, a "war" is declared.
   - Then, the player with the higher-ranked suit wins that round of the game.
   
   Winning the Game:
   
   - The game continues until there are no more cards left.
   - The player with the most number of won rounds, wins.
   
   
   
Enjoy the classic game of War! May luck be with you!
   
"""        
        print(note)
        
    def __init__(self) -> None:
        self.explain_game()
        name1: str = input('Please enter player 1\'s name: ')
        name2: str = input('Please enter player 2\'s name: ')
        self.deck: Deck = Deck()
        self.p1: Player = Player(name1)
        self.p2: Player = Player(name2)
        
    def wins(self, winner: Player) -> None:
        message: str = f"{winner.name} wins this round!"
        print(message)
        print(60 * '~')
        
    def draw(self, p1_name: str, p1_card: Card, p2_name: str,
             p2_card: Card) -> None:
        
        print(60 * '~')
        message: str = f"{p1_name} drew {p1_card}; {p2_name} drew {p2_card}."
        print(message)
        
    def play_game(self) -> None:
        cards: Deck = self.deck.cards
        print('\nBeginning War!!!')
        print('----------------')
        
        while len(cards) >= 2:
            message: str = "\nPress q to quit. Press any other key to play:\n"
            response: str = input(message)
            if response == 'q':
                break
            p1_card: Card = self.deck.rm_card()
            p2_card: Card = self.deck.rm_card()
            p1_name: str = self.p1.name
            p2_name: str = self.p2.name
            self.draw(p1_name, p1_card, p2_name, p2_card)
            if p1_card > p2_card:
                self.p1.wins += 1
                self.wins(self.p1)
            else:
                self.p2.wins += 1
                self.wins(self.p2)       
                
        win = self.winner(self.p1, self.p2)
        
        if win == None:
            print("War is over. It was a tie!")
        else:
            print(f"War is over.{win} wins!!!")
        
    def winner(self, p1: Player, p2: Player) -> str:
        if p1.wins > p2.wins:
            return p1.name
        elif p2.wins > p1.wins:
            return p2.name
        else:
            return None
            
if __name__ == '__main__':
    game: Game = Game()
    game.play_game()
        