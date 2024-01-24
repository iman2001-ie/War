class Card:
    """Card class"""
    # Note: The suits are arranged in order of strength with clubs being 
    #       the strongest and spades being the weakest suit.
    suits: tuple[str] = ('spades', 'hearts', 'diamonds', 'clubs')
    
    # The first two value are "None" so that the indexing matches the numbers.
    # Note: The "Ace" is a high card in this game.
    values: tuple[str] = (None, None, '2', '3', '4', '5', '6', '7', '8', '9', 
                          '10','Jack', 'Queen', 'King', 'Ace') 

    def __init__(self, v: int, s: int) -> None:
        """suit + value are ints"""
        self.value: int = v
        self.suit: int = s
        
    def __lt__(self, c2: object) -> bool:
        if self.value < c2.value:
            return True
        if self.value == c2.value and self.suit < c2.suit:
            return True
        else:
            return False
        
    def __gt__(self, c2: object) -> bool: 
        if self.value > c2.value:
            return True
        if self.value == c2.value and self.suit > c2.suit:
            return True
        else:
            return False
        
    def __repr__(self) -> str:
        string: str = self.values[self.value] + " of " \
            + self.suits[self.suit]
        
        return string

